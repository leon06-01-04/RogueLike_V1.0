package main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public boolean leftMousePressed, rightMousePressed;

    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {
            leftMousePressed = true;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightMousePressed = true;
        }

    }

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftMousePressed = false;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightMousePressed = false;
        }
    }

        public void mouseClicked(MouseEvent e) {
        //leer
    }

    public void mouseEntered(MouseEvent e) {
        //leer
    }

    public void mouseExited(MouseEvent e) {
        //leer
    }
}
