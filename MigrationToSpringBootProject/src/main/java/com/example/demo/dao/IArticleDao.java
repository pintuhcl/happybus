package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Article;

public interface IArticleDao {
	
	  List<Article> getAllArticles();
	    Article getArticleById(int articleId);
	    void addArticle(Article article);
	    void updateArticle(Article article);
	    void deleteArticle(int articleId);
	    boolean articleExists(String title, String category);

}
