/**
 * Copyright 2015, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.nlp.decode;

import edu.emory.mathcs.nlp.common.util.XMLUtils;
import edu.emory.mathcs.nlp.component.template.config.NLPConfig;
import edu.emory.mathcs.nlp.structure.dependency.NLPNode;

import org.w3c.dom.Element;

import java.io.InputStream;

/**
 * This class contains the specification of components to use in a decoder.
 * It is usually initialized from an XML file, but may be initialized manually
 * if an application prefers. It stores the names of models for the desired
 * components as {@code String} values. By convention, these are interpreted
 * as either a classpath reference or a URI that can be converted to a {@link java.nio.file.Path}.
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class DecodeConfig extends NLPConfig<NLPNode>
{
	private String part_of_speech_tagging;
	private String named_entity_recognition;
	private String dependency_parsing;
	private String semantic_role_labeling;
	
	public DecodeConfig() {}
	
	public DecodeConfig(InputStream in)
	{
		super(in);
		initComponents();
	}
	
	public void initComponents()
	{
		Element eModels = XMLUtils.getFirstElementByTagName(xml, "models");
		
		setPartOfSpeechTagging   (XMLUtils.getTextContentFromFirstElementByTagName(eModels, "pos"));
		setNamedEntityRecognition(XMLUtils.getTextContentFromFirstElementByTagName(eModels, "ner"));
		setDependencyParsing     (XMLUtils.getTextContentFromFirstElementByTagName(eModels, "dep"));
		setSemanticRoleLabeling  (XMLUtils.getTextContentFromFirstElementByTagName(eModels, "srl"));
	}
	
	public String getPartOfSpeechTagging()
	{
		return part_of_speech_tagging;
	}
	
	public String getNamedEntityRecognition()
	{
		return named_entity_recognition;
	}
	
	public String getDependencyParsing()
	{
		return dependency_parsing;
	}
	
	public String getSemanticRoleLabeling()
	{
		return semantic_role_labeling;
	}
	
	public void setPartOfSpeechTagging(String filename)
	{
		part_of_speech_tagging = filename;
	}
	
	public void setNamedEntityRecognition(String filename)
	{
		named_entity_recognition = filename;
	}
	
	public void setDependencyParsing(String filename)
	{
		dependency_parsing = filename;
	}
	
	public void setSemanticRoleLabeling(String filename)
	{
		semantic_role_labeling = filename;
	}
}
