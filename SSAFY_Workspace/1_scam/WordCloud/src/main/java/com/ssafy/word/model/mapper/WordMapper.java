package com.ssafy.word.model.mapper;

import java.util.List;

import com.ssafy.word.model.WordDto;

/**
 * @author hissam
 */
public interface WordMapper {

	List<WordDto> listWord();
	void updateCount(String word);
	
}
