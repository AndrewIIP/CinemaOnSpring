package com.polishchuk.cinema.cinema.data.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TicketDto {
    private int id;
    private int place;
    private int userId;
    private int sessionId;
}
