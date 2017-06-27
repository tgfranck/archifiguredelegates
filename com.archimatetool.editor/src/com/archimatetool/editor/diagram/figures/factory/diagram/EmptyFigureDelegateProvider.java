package com.archimatetool.editor.diagram.figures.factory.diagram;

import org.eclipse.draw2d.IFigure;

import com.archimatetool.editor.diagram.figures.diagram.EmptyFigure;
import com.archimatetool.editor.diagram.figures.factory.AbstractFigureDelegateProvider;

public class EmptyFigureDelegateProvider extends AbstractFigureDelegateProvider {

	@Override
	public Class<? extends IFigure> providerFor() {
		return EmptyFigure.class;
	}

}
