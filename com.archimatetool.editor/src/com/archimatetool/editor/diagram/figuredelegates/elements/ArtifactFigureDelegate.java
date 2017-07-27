package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;
import com.archimatetool.editor.ui.ColorFactory;

public class ArtifactFigureDelegate extends AbstractPolygonalFigureDelegate {
	
    protected static final int FOLD_HEIGHT = 18;

	public ArtifactFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	@Override
    public void drawFigure(Graphics graphics) {
        graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }

        // Fill
        PointList points1 = new PointList();
        points1.addPoint(bounds.x, bounds.y);
        points1.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y);
        points1.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y + FOLD_HEIGHT);
        points1.addPoint(bounds.x + bounds.width - 1, bounds.y + FOLD_HEIGHT);
        points1.addPoint(bounds.x + bounds.width - 1, bounds.y + bounds.height - 1);
        points1.addPoint(bounds.x, bounds.y + bounds.height - 1);

        graphics.setBackgroundColor(getFillColor());

        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }
        
        graphics.fillPolygon(points1);
        
        if(gradient != null) {
            gradient.dispose();
        }
        
        // Fold
        PointList points2 = new PointList();
        points2.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y);
        points2.addPoint(bounds.x + bounds.width - 1, bounds.y + FOLD_HEIGHT);
        points2.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y + FOLD_HEIGHT);
        graphics.setBackgroundColor(ColorFactory.getDarkerColor(getFillColor()));
        graphics.fillPolygon(points2);
        
        // Line
        graphics.setForegroundColor(getLineColor());
        graphics.drawPolygon(points1);
        graphics.drawLine(points1.getPoint(1), points1.getPoint(3));
        
        graphics.popState();
    }

	@Override
	public void drawShape(Graphics graphics) {
		 graphics.pushState();
	        
		 Rectangle bounds = getBounds().getCopy();	
		 
	 // Fill
        PointList points1 = new PointList();
        points1.addPoint(bounds.x, bounds.y);
        points1.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y);
        points1.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y + FOLD_HEIGHT);
        points1.addPoint(bounds.x + bounds.width - 1, bounds.y + FOLD_HEIGHT);
        points1.addPoint(bounds.x + bounds.width - 1, bounds.y + bounds.height - 1);
        points1.addPoint(bounds.x, bounds.y + bounds.height - 1);
        
        graphics.fillPolygon(points1);
        
     // Fold
        PointList points2 = new PointList();
        points2.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y);
        points2.addPoint(bounds.x + bounds.width - 1, bounds.y + FOLD_HEIGHT);
        points2.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y + FOLD_HEIGHT);
        
        graphics.fillPolygon(points2);
        
     // Line
        graphics.drawPolygon(points1);
        graphics.drawLine(points1.getPoint(1), points1.getPoint(3));
        
        graphics.popState();
	}

	@Override
	public PointList getPoints() {
		Rectangle bounds = getBounds().getCopy();
		
		PointList points = new PointList();
		
        points.addPoint(bounds.x, bounds.y);
        points.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y);
        points.addPoint(bounds.x + bounds.width - FOLD_HEIGHT, bounds.y + FOLD_HEIGHT);
        points.addPoint(bounds.x + bounds.width - 1, bounds.y + FOLD_HEIGHT);
        points.addPoint(bounds.x + bounds.width - 1, bounds.y + bounds.height - 1);
        points.addPoint(bounds.x, bounds.y + bounds.height - 1);
        
        return points;
	}

}
