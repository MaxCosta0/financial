package com.maxley.financial.utils.pagination

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class GenericPagination{
    companion object {
        fun <T> of(items: List<T>, pageable: Pageable): Page<T> {

            return PageImpl(
                items.subList(pageable.offset.toInt(), minOf(pageable.offset.toInt() + pageable.pageSize, items.size)),
                pageable,
                items.size.toLong()
            )
        }
    }
}