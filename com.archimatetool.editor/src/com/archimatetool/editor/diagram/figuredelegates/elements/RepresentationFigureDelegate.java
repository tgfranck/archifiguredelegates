package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figures.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;
import com.archimatetool.model.ITextPosition;

public class RepresentationFigureDelegate extends AbstractFigureDelegate {
	
	protected static final int TOP_MARGIN = 12;

	public RepresentationFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	public void drawFigure(Graphics graphics){
		 graphics.pushState();
	        
        Rectangle bounds = getBounds().getCopy();
        
        int offset = 6;
        int curve_y = bounds.y + bounds.height - offset;
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        // Main Fill
        Path path = new Path(null);
        path.moveTo(bounds.x, bounds.y);
        path.lineTo(bounds.x, curve_y - 1);
        
        path.quadTo(bounds.x + (bounds.width / 4), bounds.y + bounds.height + offset - 1,
                bounds.x + bounds.width / 2 + 1, curve_y - 1);
        
        path.quadTo(bounds.x + bounds.width - (bounds.width / 4), curve_y - offset - 2,
                bounds.x + bounds.width - 1, curve_y - 1);
        
        path.lineTo(bounds.x + bounds.width - 1, bounds.y);
        
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }
        
        graphics.fillPath(path);
        
        if(gradient != null) {
            gradient.dispose();
        }

        // Outline
        graphics.setForegroundColor(getLineColor());
        path.lineTo(bounds.x, bounds.y);
        graphics.drawPath(path);
        path.dispose();
        
        // Line
        graphics.drawLine(bounds.x, bounds.y + TOP_MARGIN, bounds.x + bounds.width, bounds.y + TOP_MARGIN);
        
        graphics.popState();
	}
	
	@Override
    public Rectangle calculateTextControlBounds() {
        Rectangle bounds = getBounds().getCopy();
        
        int textPosition = ((ITextPosition)getOwner().getDiagramModelObject()).getTextPosition();
        
        if(textPosition == ITextPosition.TEXT_POSITION_TOP) {
            bounds.y += TOP_MARGIN - 4;
        }
        
        return bounds;
    }

}
