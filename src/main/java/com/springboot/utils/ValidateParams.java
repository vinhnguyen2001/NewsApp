package com.springboot.utils;

import org.springframework.data.domain.Sort;

public class ValidateParams {


    public static int validatePage(Integer page){
        if(page <= 0){
            page = 1;
        }
        return page;
    }
    public static int validateLimit(Integer limit){
        if(limit <= 0){
            limit = 5;
        }
        return limit;
    }

    public static Sort.Direction validateSort(String sort){
        if (sort.equals("") || sort.equals("DESC")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;

    }
    public static String validateSortBy (String sortBy){

        if(sortBy.equals("")){
            sortBy = "id";
        }
        return sortBy;
    }


}
