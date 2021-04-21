package com.grsu.tick.tack.toe.core.events;


import com.grsu.tick.tack.toe.core.field.Figure;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FieldChangedEvent {
    private final Figure[][] field;


}
