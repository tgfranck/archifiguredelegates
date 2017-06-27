package com.archimatetool.editor.diagram.figures.factory.elements;

import org.eclipse.draw2d.IFigure;

import com.archimatetool.editor.diagram.figures.elements.CommunicationNetworkFigure;
import com.archimatetool.editor.diagram.figures.factory.AbstractFigureDelegateProvider;

public class CommunicationNetworkFigureDelegateProvider extends AbstractFigureDelegateProvider {

	@Override
	public Class<? extends IFigure> providerFor() {
		return CommunicationNetworkFigure.class;
	}

}
