package TP7;

import Taller.List;

public interface FilterList<T> extends List<T> {
    FilterList<T> filter(Criteria<T> criteria);
}
