package com.polishchuk.cinema.cinema.data.mapper;

import com.polishchuk.cinema.cinema.data.dto.UserDto;
import com.polishchuk.cinema.cinema.data.entity.Ticket;
import com.polishchuk.cinema.cinema.data.entity.User;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "roles", target = "roles"),
            @Mapping(source = "active", target = "active"),
    })
    User dtoToUser(UserDto userDto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "roles", target = "roles"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "userTickets", target = "ticketList"),
    })
    UserDto userToDto(User user);

    @AfterMapping
    default void calledWithSourceAndTarget(User user, @MappingTarget UserDto userDto){
        Iterator<Ticket> iterator = user.getUserTickets().iterator();

        userDto.getTicketList().forEach(ticket -> ticket.setUserId(user.getId()));
        userDto.getTicketList().forEach(ticket -> ticket.setSessionId(iterator.next().getSession().getId()));
    }
}
