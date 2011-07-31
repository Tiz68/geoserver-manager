/*
 *  GeoServer-Manager - Simple Manager Library for GeoServer
 *  
 *  Copyright (C) 2007,2011 GeoSolutions S.A.S.
 *  http://www.geo-solutions.it
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package it.geosolutions.geoserver.rest.encoder;

import org.jdom.Element;

import it.geosolutions.geoserver.rest.encoder.utils.PropertyXMLEncoder;

/**
 *
 * @author ETj (etj at geo-solutions.it)
 * @author Carlo Cancellieri - carlo.cancellieri@geo-solutions.it
 */
public class GSWorkspaceEncoder extends PropertyXMLEncoder {

    public GSWorkspaceEncoder() {
        super("workspace");
    }

    public GSWorkspaceEncoder(String name) {
    	super("workspace");
        addName(name);
    }
    
    /**
     * Add the name to this workspace
     * @param name
     * @throws IllegalStateException if name is already set
     */
    public void addName(String name) {
    	final Element el=contains("name");
    	if (el==null)
    		add("name", name);
    	else
    		throw new IllegalStateException("Workspace name is already set: "+el.getText());
    }
    
    /**
     * add or change (if already set) the workspace name
     * @param name
     */
    public void setName(String name) {
    	final Element el=contains("name");
    	if (el==null)
    		add("name", name);
    	else
    		el.setText(name);
    }
    
    public String getName(){
    	final Element el=contains("name");
    	if (el!=null)
    		return el.getTextTrim();
    	else
    		return null;
    }

}