/*Copyright(c) 2017-2018 CBA and /or its affiliates.All rights reserved
 * CBA Proprietary/Confidential.Use its subject to license terms.
  */
package com.cbabackend.processor;

import com.cbabackend.beans.Card;

/*This interface is used to process all the cards data read from flat files
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 * 
 * */
public interface CardItemProcessor {
	
	
	/*This method is used to process the data coming from flat files 
	 * 
	 * @author Rahul M.
	 * @return{@link Card}
	 * 
	 * 
	 * */
	
	public Card process(Card card);

}
