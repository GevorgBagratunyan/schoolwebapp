package com.gevbagratunyan.school.service.crud;

public interface CreateSupported<Request, Response>{
    Response add(Request request);
}
