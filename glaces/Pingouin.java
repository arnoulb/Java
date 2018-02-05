package glaces;
import geometrie.Point ;
import java.util.Random;
import glaces.Iceberg2D;

public class Pingouin {

    private Point	pos;
    private int		width;
    private int		height;

    public Pingouin() {
	width = 20;
	height = 20;
	pos = new Point(480, 480);
    }
    public void moveLeft(int w, int h) {
	if (pos.getAbscisse() - width > 0) {
	    pos = new Point(pos.getAbscisse() - width, pos.getOrdonnee());
	}
    }

    public void moveRight(int w, int h) {
	if (pos.getAbscisse() + width < w) {
	    pos = new Point(pos.getAbscisse() + width, pos.getOrdonnee());
	}
    }

    public void moveUp(int w, int h) {
	if (pos.getOrdonnee() - height > 0) {
	    pos = new Point(pos.getAbscisse(), pos.getOrdonnee() - height);
	}    
    }
    
    public void moveDown(int w, int h) {
	if (pos.getOrdonnee() + height < h) {
	    pos = new Point(pos.getAbscisse(), pos.getOrdonnee() + height);
	}
    }

    public Point getPosition() {
	return (this.pos);
    }

    public int getLargeur() {
	return (this.width);
    }

    public int getHauteur() {
	return (this.height);
    }

}
