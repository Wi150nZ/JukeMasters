
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author BlakeAllen
 */
public class Sheild extends GameObject {

    Handler handler;

    public Sheild(float x, float y, ID id, Handler handler, int Id) {
        super(x, y, id, Id);
        this.handler = handler;
        speedX = 7;
        speedY = 7;
		Id = Handler.counter;
    }

    public void tick() {
        x += speedX;
        y += speedY;
        if (y <= 70 || y >= Game.HEIGHT - 47) {
            speedY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 26) {
            speedX *= -1;
        }
        if (Player.collisionS) {
        	/*if(SheildBar.Exists){
        		Hud.sheildHp = 100;
        	}*/
            handler.add(new SheildBar(0,0,ID.SheildBar,handler, handler.counter));
            handler.remove(Player.removeId);
        }
        
        x = Game.clamp((int) x, 0, Game.WIDTH - 26);
        y = Game.clamp((int) y, 70, Game.HEIGHT - 47);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 14, 14);
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.CYAN);
        g.fillOval((int) x, (int) y, 14, 14);
        g.setColor(Color.white);
        g.drawOval((int) x, (int) y, 14, 14);
    }

}
