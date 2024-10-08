package src.tile;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.GamePanel;

public class TileManager {
  GamePanel gp;
  Tile[] tile;

  public TileManager(GamePanel gp) {
    this.gp = gp;
    tile = new Tile[1];
    getTileImage();
  }

  public void getTileImage() {
    try {
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Floor1.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setTileRectangles() {
    int x = 0;
    int y = gp.screenHeight - 42;
    int tileRemoval[] = { 10, 11, 12, 13 };

    for (int i = 0; i < (gp.screenWidth / gp.tileSize + 1); i++) {
      boolean found = false;
      for (int value : tileRemoval) {
        if (value == i) {
          found = true;
        }
      }

      if (found) {
        x += gp.tileSize;
        continue;
      }
      gp.tiles.add(new Rectangle(x, y, gp.tileSize, gp.tileSize));
      x += gp.tileSize;
    }
  }

  public void draw(Graphics2D g2) {
    // set tile locations for floor
    int x = 0;
    int y = gp.screenHeight - 42;
    int tileRemoval[] = { 10, 11, 12, 13 };

    // timesRun = 159
    for (int i = 0; i < (gp.screenWidth / gp.tileSize + 1); i++) {
      boolean found = false;
      for (int value : tileRemoval) {
        if (value == i) {
          found = true;
        }
      }

      if (found) {
        x += gp.tileSize;
        continue;
      }

      g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
      x += gp.tileSize;
    }
  }
}
