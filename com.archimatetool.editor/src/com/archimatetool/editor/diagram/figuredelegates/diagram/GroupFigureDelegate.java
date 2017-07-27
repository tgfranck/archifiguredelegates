package com.archimatetool.editor.diagram.figuredelegates.diagram;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figuredelegates.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;
import com.archimatetool.editor.ui.ColorFactory;

public class GroupFigureDelegate extends AbstractFigureDelegate {
	
    protected static final int TOPBAR_HEIGHT = 18;
    private static final float INSET = 2f;

	public GroupFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	 @Override
	public void drawFigure(Graphics graphics) {
	        graphics.pushState();
	        
	        Rectangle bounds = getBounds().getCopy();
	        
	        graphics.setAntialias(SWT.ON);
	        
	        int[] topRectangle = new int[] {
	                bounds.x, bounds.y,
	                (int)(bounds.x + (bounds.width / INSET) - 1), bounds.y,
	                (int)(bounds.x + (bounds.width / INSET) - 1), bounds.y + TOPBAR_HEIGHT,
	                bounds.x, bounds.y + TOPBAR_HEIGHT,
	        };

	        int[] mainRectangle = new int[] {
	                bounds.x, bounds.y + TOPBAR_HEIGHT,
	                bounds.x + bounds.width - 1, bounds.y + TOPBAR_HEIGHT,
	                bounds.x + bounds.width - 1, bounds.y + bounds.height - 1,
	                bounds.x, bounds.y + bounds.height - 1
	        };
	        
	        graphics.setBackgroundColor(ColorFactory.getDarkerColor(getFillColor()));
	        graphics.fillPolygon(topRectangle);
	       
	        graphics.setBackgroundColor(getFillColor());

	        Pattern gradient = null;
	        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
	            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
	            graphics.setBackgroundPattern(gradient);
	        }
	        
	        graphics.fillPolygon(mainRectangle);
	        
	        if(gradient != null) {
	            gradient.dispose();
	        }

	        // Line
	        graphics.setForegroundColor(getLineColor());
	        graphics.drawPolygon(topRectangle);
	        graphics.drawPolygon(mainRectangle);
	        
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
	        
	        int[] topRectangle = new int[] {
	                bounds.x, bounds.y,
	                (int)(bounds.x + (bounds.width / INSET) - 1), bounds.y,
	                (int)(bounds.x + (bounds.width / INSET) - 1), bounds.y + TOPBAR_HEIGHT,
	                bounds.x, bounds.y + TOPBAR_HEIGHT,
	        };

	        int[] mainRectangle = new int[] {
	                bounds.x, bounds.y + TOPBAR_HEIGHT,
	                bounds.x + bounds.width - 1, bounds.y + TOPBAR_HEIGHT,
	                bounds.x + bounds.width - 1, bounds.y + bounds.height - 1,
	                bounds.x, bounds.y + bounds.height - 1
	        };
	        
	        graphics.fillPolygon(topRectangle);	        
	        graphics.fillPolygon(mainRectangle);

	     // Line
	        graphics.drawPolygon(topRectangle);
	        graphics.drawPolygon(mainRectangle);
	        
	        graphics.popState();			
		}

}
