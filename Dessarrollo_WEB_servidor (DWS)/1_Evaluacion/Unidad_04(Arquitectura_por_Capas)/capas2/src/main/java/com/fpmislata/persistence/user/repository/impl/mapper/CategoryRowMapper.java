package com.fpmislata.persistence.user.repository.impl.mapper;

import com.fpmislata.common.locale.LanguageUtils;
import com.fpmislata.domain.user.entity.Category;
import com.fpmislata.persistence.common.CustomRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements CustomRowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Category category = new Category();
        category.setId(rs.getInt("categories.id"));
        category.setName(rs.getString("categories.name_" + language));
        category.setSlug(rs.getString("categories.slug"));
        return category;
    }
}
