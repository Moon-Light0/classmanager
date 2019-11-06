package com.just.manager.dao;

import com.just.manager.domain.Vacation;

public interface IVacationMapper {
    Vacation findByLId(String lId);
}
