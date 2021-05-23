package com.example.StreamProcessing.filterRegistry;

import com.example.StreamProcessing.consumer.TweetConsumerListener;
import com.example.StreamProcessing.filter.Filter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SimpleFilterRegistry implements FilterRegistry{
    Map<String, Filter> activeFilters = new HashMap<>();
    Map<String, Filter> inActiveFilters = new HashMap<>();

    private TweetConsumerListener tweetConsumerListener;

    public SimpleFilterRegistry(TweetConsumerListener tweetConsumerListener){
        this.tweetConsumerListener = tweetConsumerListener;
    }

    @Override public void createFilter(Filter filter) {
        activeFilters.put(filter.getName(), filter);
        tweetConsumerListener.addFilter(filter);
    }

    @Override public Boolean enableFilter(String name) {
        if(!activeFilters.containsKey(name)){
            Filter filter = inActiveFilters.remove(name);
            activeFilters.put(filter.getName(), filter);
            return  tweetConsumerListener.addFilter(filter);
        }
        return activeFilters.containsKey(name) || inActiveFilters.containsKey(name);
    }

    @Override public Boolean disableFilter(String name) {
        if(!inActiveFilters.containsKey(name)) {
            Filter filter = activeFilters.remove(name);
            inActiveFilters.put(filter.getName(), filter);
            return tweetConsumerListener.removeFilter(filter);
        }
        return inActiveFilters.containsKey(name) || activeFilters.containsKey(name);
    }

    @Override public List<Filter> getAllFilters() {
        List<Filter> filters = Stream.concat(activeFilters.entrySet().stream(),
                inActiveFilters.entrySet().stream()).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        return filters;
    }
}
