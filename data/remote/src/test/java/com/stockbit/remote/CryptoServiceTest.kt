/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package com.stockbit.remote

import com.stockbit.remote.base.BaseTest
import org.junit.Test
import retrofit2.HttpException

class CryptoServiceTest: BaseTest() {

    @Test
    fun `get example success`() {

    }

    @Test(expected = HttpException::class)
    fun `get example fail`() {

    }
}