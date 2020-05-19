package com.example.repopatterndesign.datamapper

/**
 * map DTOs into Domain Models and vice-versa.
 */
interface Mapper<I, O> {
    fun map(input: I): O
}