package block;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

import main.ImageHandler;
import main.SpielPanel;

public class Blockmanager {

    private SpielPanel panel;
    private Map<Integer, Block> blockMap = new HashMap<>(); // Use Integer as the key type
    Block[] blocks;
    ImageIcon image;

    private int col = 0;
    private int row = 0;
    private int x = 0;
    private int y = 0;
    int[][] mapBlockNum;

    public Blockmanager(SpielPanel panel) {

        mapBlockNum = new int[panel.FIELD_SIZE][panel.FIELD_SIZE];
        this.panel = panel;
        getBlockImage();
        loadMap("2t");
    }

    private void getBlockImage() {

        // ImageIcon icon = new ImageIcon("dirt.png");

        try {
            Block block = new Block();
            block.image = ImageHandler.readImage("resources\\grass.png");
            blockMap.put(0, block);

            block = new Block();
            block.image = ImageHandler.readImage("resources\\water.png");
            blockMap.put(1, block);

            block = new Block();
            block.image = ImageHandler.readImage("resources\\wall_stone.png");
            blockMap.put(2, block);

            block = new Block();
            block.image = ImageHandler.readImage("resources\\dirt.png");
            blockMap.put(3, block);

            block = new Block();
            block.image = ImageHandler.readImage("resources\\sand.png");
            blockMap.put(4, block);


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public BufferedImage getTile(int tileName) {
        return blockMap.get(tileName).image;
    }

    public void loadMap(String pathToMap) {
        try {
            // Read text file
            InputStream is = getClass().getResourceAsStream(pathToMap);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while (col < panel.FIELD_SIZE && row < panel.FIELD_SIZE) {
                String line = br.readLine();

                while (col < panel.FIELD_SIZE) {
                    String[] tileNames = line.split(",");
                    int tileName = Integer.parseInt(tileNames[col]);
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
