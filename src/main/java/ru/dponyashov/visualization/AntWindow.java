package ru.dponyashov.visualization;

import javax.swing.*;
import java.awt.*;

public class AntWindow extends JFrame {
    public AntWindow(){
        setTitle( "Ant" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.height -= 40;
        setSize( screenSize );
        setLocation( 0, 0 );
        int cellSize = 1;
        int antCount = 500;
        add( new AntField( screenSize, cellSize, antCount) );
        setVisible( true );
    }
}
