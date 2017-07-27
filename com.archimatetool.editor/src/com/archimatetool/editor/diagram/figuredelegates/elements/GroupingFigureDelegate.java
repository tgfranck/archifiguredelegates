package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figuredelegates.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;

public class GroupingFigureDelegate extends AbstractFigureDelegate {
	
    private static final int TOPBAR_HEIGHT = 18;
    private static final float INSET = 1.4f;

	public GroupingFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	@Override
	public void drawFigure(Graphics graphics){
		graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        graphics.setAntialias(SWT.ON);
        
        graphics.setLineDash(new float[] { (float)(8 * graphics.getAbsoluteScale()), (float)(4 * graphics.getAbsoluteScale()) });
        
        graphics.setBackgroundColor(getFillColor());
       
        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }
        
        int[] fillShape = new int[] {
                bounds.x, bounds.y,
                (int)(bounds.x + (bounds.width / INSET)), bounds.y,
                (int)(bounds.x + (bounds.width / INSET)), bounds.y + TOPBAR_HEIGHT,
                bounds.getRight().x, bounds.y + TOPBAR_HEIGHT,
                bounds.getRight().x, bounds.getBottom().y,
                bounds.x, bounds.getBottom().y
        };
        
        graphics.fillPolygon(fillShape);
        
        if(gradient != null) {
            gradient.dispose();
        }

        // Outlines
        graphics.setForegroundColor(getLineColor());
        
        int[] mainRectangle = new int[] {
                bounds.x, bounds.y + TOPBAR_HEIGHT,
                bounds.x + bounds.width - 1, bounds.y + TOPBAR_HEIGHT,
                bounds.x + bounds.width - 1, bounds.y + bounds.height - 1,
                bounds.x, bounds.y + bounds.height - 1
        };
        
        graphics.drawPolygon(mainRectangle);
        
        graphics.drawLine(bounds.x, bounds.y, bounds.x, bounds.y + TOPBAR_HEIGHT);
        graphics.drawLine(bounds.x, bounds.y, (int)(bounds.x + (bounds.width / INSET)), bounds.y);
        graphics.drawLine((int)(bounds.x + (bounds.width / INSET)), bounds.y, (int)(bounds.x + (bounds.width / INSET)), bounds.y + TOPBAR_HEIGHT);

        graphics.popState();
	}
	
    @Override
    public Rectangle calculateTextControlBounds() {
        Rectangle bounds = getBounds().getCopy();
        
        // This first
        bounds.x += 5;
        bounds.y += 2;

        bounds.width = getOwner().getTextControl().getPreferredSize().width;
        bounds.height = getOwner().getTextControl().getPreferredSize().height;
        
        return bounds;
    }

	@Override
	public void drawShape(Graphics graphics) {
		graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        graphics.setAntialias(SWT.ON);
        
        graphics.setLineDash(new float[] { (float)(8 * graphics.getAbsoluteScale()), (float)(4 * graphics.getAbsoluteScale()) });		
	
        int[] fillShape = new int[] {
                bounds.x, bounds.y,
                (int)(bounds.x + (bounds.width / INSET)), bounds.y,
                (int)(bounds.x + (bounds.width / INSET)), bounds.y + TOPBAR_HEIGHT,
                bounds.getRight().x, bounds.y + TOPBAR_HEIGHT,
                bounds.getRight().x, bounds.getBottom().y,
                bounds.x, bounds.getBottom().y
        };
        
        graphics.fillPolygon(fillShape);
        
        int[] mainRectangle = new int[] {
                bounds.x, bounds.y + TOPBAR_HEIGHT,
                bounds.x + bounds.width - 1, bounds.y + TOPBAR_HEIGHT,
                bounds.x + bounds.width - 1, bounds.y + bounds.height - 1,
                bounds.x, bounds.y + bounds.height - 1
        };
        
        graphics.drawPolygon(mainRectangle);
        
        graphics.drawLine(bounds.x, bounds.y, bounds.x, bounds.y + TOPBAR_HEIGHT);
        graphics.drawLine(bounds.x, bounds.y, (int)(bounds.x + (bounds.width / INSET)), bounds.y);
        graphics.drawLine((int)(bounds.x + (bounds.width / INSET)), bounds.y, (int)(bounds.x + (bounds.width / INSET)), bounds.y + TOPBAR_HEIGHT);

        graphics.popState();
	}

}
