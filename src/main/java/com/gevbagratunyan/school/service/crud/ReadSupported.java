package com.gevbagratunyan.school.service.crud;


public interface ReadSupported<ID, Response>{
    Response get(ID id);
}
