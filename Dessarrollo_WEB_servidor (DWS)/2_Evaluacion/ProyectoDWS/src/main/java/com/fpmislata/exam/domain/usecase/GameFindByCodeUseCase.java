package com.fpmislata.exam.domain.usecase;

import com.fpmislata.exam.domain.model.Game;

public interface GameFindByCodeUseCase {
    Game findByCode(String code);
}
