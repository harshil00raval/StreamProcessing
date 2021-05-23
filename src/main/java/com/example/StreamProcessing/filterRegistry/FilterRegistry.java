package com.example.StreamProcessing.filterRegistry;

import com.example.StreamProcessing.filter.Filter;

import java.util.List;

public interface FilterRegistry {

    void createFilter(Filter filter);
    Boolean enableFilter(String name);
    Boolean disableFilter(String name);
    List<Filter> getAllFilters();
}
