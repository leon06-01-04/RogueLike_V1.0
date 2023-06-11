package block;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.ImageHandler;
import main.SpielPanel;

public class Blockmanager {

    private SpielPanel panel;
    private Map<String, Block> blockMap = new HashMap<>(); // Map each array index to a string for better readability
    Block[] block;
    ImageIcon image;

    private int col = 0;
    private int row = 0;
    private int x = 0;
    private int y = 0;
    String[][] mapBlockNum = new String[panel.FIELD_SIZE][panel.FIELD_SIZE];

    public Blockmanager(SpielPanel panel) {

        this.panel = panel;
        getBlockImage();
        loadMap(pathToMap);
    }

    private void getBlockImage() {

        // ImageIcon icon = new ImageIcon("dirt.png");

        try {
            Block block = new Block();
            block.image = ImageHandler.readImage("block/grass.png");
            blockMap.put("grass", block);

            block = new Block();
            block.image = ImageHandler.readImage("block/water.png");
            blockMap.put("water", block);

            block = new Block();
            block.image = ImageHandler.readImage("block/wall_stone.png");
            blockMap.put("stone_wall", block);

            block = new Block();
            block.image = ImageHandler.readImage("block/dirt.png");
            blockMap.put("dirt", block);

            block = new Block();
            block.image = ImageHandler.readImage("block/sand.png");
            blockMap.put("sand", block);

            block = new Block();
            block.image = ImageHandler.readImage("block/tree_grass.png");
            blockMap.put("tree_grass", block);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public BufferedImage getTile(String tileName) {
        return blockMap.get(tileName).image;
    }

    public void loadMap(String pathToMap) {
        try {
            // Read text file
            InputStream is = getClass().getResourceAsStream("maps");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while (col < panel.FIELD_SIZE && row < panel.FIELD_SIZE) {
                String line = br.readLine();

                while (col < panel.FIELD_SIZE) {
                    String[] tileNames = line.split(",");
                    String tileName = tileNames[col];
                    mapBlockNum[col][row] = tileName;

                    col++;
                }
                if (col == panel.FIELD_SIZE) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        col = 0;
        row = 0;
        x = 0; // I have to do this because it starts at row No.2 if i dont...
        y = 0;

        while (col < panel.FIELD_SIZE && row <  panel.FIELD_SIZE ) {
            g2.drawImage(getTile(mapBlockNum[col][row]), x, y, panel.CELL_SIZE, panel.CELL_SIZE, null);
            col++;
            x += panel.CELL_SIZE;

            if (col == panel.FIELD_SIZE) {
                col = 0;
                x = 0;
                row++;
                y += panel.CELL_SIZE;
            }
        }
    }
}
