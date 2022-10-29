package com.company.controller.ai;

import com.company.model.MoveDto;

public class AiSuper implements Ai{
    @Override
    public String getNextPosition(MoveDto moveDto) {
        return "2";
    }
}
