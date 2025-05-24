package com.aun1x.bookworm.mappers;

//assuming A -> Entity, B -> Dto
public interface Mapper<A, B> {
    A mapToEntity(B b);

    B maptoDto(A a );

}
