package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

// bean으로 등록 할수 있도록 Service를 선언한다.
@Service
public class MovieServiceImpl implements MovieService {

	private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	private MovieDao movieDao;

	/**
	 * 파일 업로드 경로를 설정하기 위해 ResourceLoader를 주입받는다.
	 */
	@Autowired
	ResourceLoader resLoader;

	public MovieDao getMovieRepo() {
		return movieDao;
	}

	/**
	 * setter를 통해 MovieDao을 주입 받는다.
	 * 
	 * @param MovieDao
	 */
	@Autowired
	public void setMovieRepo(MovieDao dao) {
		this.movieDao = dao;
	}

	@Override
	@Transactional
	public int insert(Movie movie, MultipartFile file) throws IllegalStateException, IOException {
		fileHandling(movie, file);
		return movieDao.insert(movie);
	}

	@Override
	@Transactional
	public int delete(int id) {
		return movieDao.delete(id);

	}

	@Override
	public List<Movie> selectAll() {
		return movieDao.selectAll();
	}

	@Override
	public List<Movie> search(String title) {
		return movieDao.search(title);
	}

	private void fileHandling(Movie movie, MultipartFile file) throws IOException {
		// 파일을 저장할 폴더 지정
		Resource res = resLoader.getResource("resources/upload");
		logger.debug("res: {}", res.getFile().getCanonicalPath());
		if (file != null && file.getSize() > 0) {
			// prefix를 포함한 전체 이름
			movie.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			movie.setOrgImg(file.getOriginalFilename());

			// 변경된 파일 이름이 적용된 Movie MovieService를 통해 DB에 저장한다.

			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + movie.getImg()));
		}

	}

}
