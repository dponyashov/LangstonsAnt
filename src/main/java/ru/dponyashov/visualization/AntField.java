package ru.dponyashov.visualization;

import ru.dponyashov.ant.Ant;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AntField extends JPanel implements ActionListener {

    private final Color backColor = Color.BLACK;
    private final Color[] blacks = { Color.RED, Color.BLUE, Color.ORANGE, Color.GREEN, Color.PINK, Color.YELLOW, Color.GRAY };
    private final Color[] whites = { Color.WHITE };
    private final int cellSize;
    private final int cellCountX;
    private final int cellCountY;
    private PointOnMap[][] map;
    private ArrayList<Ant> ants;

    public AntField( Dimension screenSize, int cellSize, int antCount ) {
        this.cellSize = cellSize;
        this.cellCountX = ( screenSize.width - 15 ) / cellSize;
        this.cellCountY = ( screenSize.height - 40 ) / cellSize;
        setBackground(backColor);
        initField( antCount );
    }
    @Override
    protected void paintComponent( Graphics g ){
        super.paintComponent( g );
        for ( int x = 0; x < cellCountX; x++ ){
            for ( int y = 0; y < cellCountY; y++ ){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor( map[x][y].getColor() );
                g2d.fillRect( x * cellSize, y * cellSize, cellSize, cellSize );
            }
        }
    }
    @Override
    public void actionPerformed( ActionEvent e ){
        for( Ant ant: ants ){
            int x = ant.getX();
            int y = ant.getY();
            map[x][y].setColor( ant.nextStep( map[x][y].getState() ) );
            map[x][y].invertState();
        }
        repaint();
    }
    private void initField( int antCount ){
        map = new PointOnMap[cellCountX][cellCountY];
        for ( int i=0; i < cellCountX; i++ ){
            for (int j=0; j < cellCountY; j++ ){
                map[i][j] = new PointOnMap( backColor );
            }
        }
        ants = new ArrayList<>();
        for( int i = 0; i < antCount; i++ ){
            ants.add( new Ant( whites[(int)( Math.random() * whites.length )],
                    blacks[(int)( Math.random() * blacks.length )],
                    cellCountY,
                    cellCountX ) );
        }
        int delay = 3;
        Timer timer = new Timer(delay, this);
        timer.start();
    }
}
