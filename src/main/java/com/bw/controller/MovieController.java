package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bw.entity.Movie;
import com.bw.entity.Type;
import com.bw.service.MovieService;
import com.bw.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MovieController {
	
	@Resource
	private MovieService service;
	
	
	@RequestMapping("/list")
	public ModelAndView queryAll(@RequestParam(defaultValue="1")Integer pageNum) {
		ModelAndView mv = new ModelAndView();
		
		PageHelper.startPage(pageNum, 3);
		List<Movie> list = service.queryAll();
		PageInfo<Movie> page = new PageInfo<Movie>(list);
		
		if (StringUtil.isEmpty(list)) {
			System.out.println("影视集合为空!");
		}
		mv.setViewName("list");
		mv.getModel().put("page", page);
		return mv;
	}
	
	
	@RequestMapping("/queryTypeList")
	@ResponseBody
	public List<Type> queryTypeList() {
		List<Type> list = service.queryTypeList();
		return list;
	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public Integer add(Movie movie, String tid) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer add = service.insertMovie(movie);
		Integer mid = movie.getMid();
		
		if (StringUtil.hasText(tid)) {
			String[] tids = tid.split(",");
			for (String str : tids) {
				map.clear();
				map.put("mid", mid);
				map.put("tid", Integer.parseInt(str));
				service.insertMovieType(map);
			}
		}
		return add;
	}
	
	//回显
	@RequestMapping("queryMovieById")
	public String queryMovieById(Integer mid, Model model) {
		Movie movie = service.queryMovieById(mid);
		List<Type> typeList = service.queryTypeList();
		List<Type> list = service.queryMovieType(mid);
		
		for (Type type : typeList) {
			for (Type t : list) {
				if (type.getTid() == t.getTid()) {
					type.setFlag(true);
				}
			}
		}
		model.addAttribute("m", movie);
		model.addAttribute("list", typeList);
		return "update";
	}
	
	//修改
	@RequestMapping("/update")
	@ResponseBody
	public Integer update(Movie movie, String tid) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer update = service.updateMovie(movie);
		Integer mid = movie.getMid();
		service.deleteMovieType(mid);
		
		if (StringUtil.hasText(tid)) {
			String[] tids = tid.split(",");
			for (String str : tids) {
				map.clear();
				map.put("mid", mid);
				map.put("tid", Integer.parseInt(str));
				service.insertMovieType(map);
			}
		}
		return update;
	}
	
	
	
	

}
