package com.gevbagratunyan.school.service.crud;

public interface UpdateSupported <ID,Request, Response>{
    Response update(ID id, Request request);
}
