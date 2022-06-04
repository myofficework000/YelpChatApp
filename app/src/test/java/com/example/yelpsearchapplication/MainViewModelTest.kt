package com.example.yelpsearchapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.yelpsearchapplication.models.Business
import com.example.yelpsearchapplication.models.BusinessSearchResponse
import com.example.yelpsearchapplication.models.Result
import com.example.yelpsearchapplication.repositories.BusinessRepository
import com.example.yelpsearchapplication.viewmodels.MainViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.verify
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    @Mock
    lateinit var businessRepository: BusinessRepository

    @Mock
    lateinit var businessListObserver: Observer<List<Business>>

    @Mock
    lateinit var resultObserver: Observer<Result<List<Business>>>

    @Mock
    lateinit var errorObserver: Observer<String>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `getAustinRestaurantList success testing`() {
        runBlocking {

            val dummyResponse = Response.success(Gson().fromJson(Constant.BUSINESS_LIST_RESPONSE, BusinessSearchResponse::class.java))

            Mockito.`when`(businessRepository.getAustinRestaurantsList()).thenReturn(dummyResponse)

            val viewModel = MainViewModel(businessRepository)

            viewModel.austinRestaurantsList.observeForever(businessListObserver)
            viewModel.restaurantsListResult.observeForever(resultObserver)

            viewModel.getAustinRestaurantsList()

            verify(businessRepository).getAustinRestaurantsList()

            val expectedResult = Gson().fromJson(Constant.BUSINESS_LIST_RESPONSE, BusinessSearchResponse::class.java)

            verify(businessListObserver).onChanged(expectedResult.businesses)
            verify(resultObserver).onChanged(Result.Success(expectedResult.businesses))

            viewModel.austinRestaurantsList.removeObserver(businessListObserver)
            viewModel.restaurantsListResult.removeObserver(resultObserver)
        }
    }

    @Test
    fun `getAustinRestaurantsList returns no data testing`() {
        runBlocking {

            val dummyResponse = Response.success(Gson().fromJson(Constant.BUSINESS_LIST_EMPTY_RESPONSE, BusinessSearchResponse::class.java))

            Mockito.`when`(businessRepository.getAustinRestaurantsList()).thenReturn(dummyResponse)

            val viewModel = MainViewModel(businessRepository)

            viewModel.austinRestaurantsList.observeForever(businessListObserver)
            viewModel.restaurantsListResult.observeForever(resultObserver)

            viewModel.getAustinRestaurantsList()

            val expectedResult = Gson().fromJson(Constant.BUSINESS_LIST_EMPTY_RESPONSE, BusinessSearchResponse::class.java)

            verify(businessRepository).getAustinRestaurantsList()

            verify(businessListObserver).onChanged(expectedResult.businesses)
            verify(resultObserver).onChanged(Result.Success(expectedResult.businesses))

            viewModel.error.removeObserver(errorObserver)
            viewModel.restaurantsListResult.removeObserver(resultObserver)
        }
    }

    @Test
    fun `getAustinRestaurantsList exception testing`() {
        runBlockingTest {

        val exception = RuntimeException("Internet is not available.")

        Mockito.`when`(businessRepository.getAustinRestaurantsList()).doThrow(exception)

        val viewModel = MainViewModel(businessRepository)

        viewModel.error.observeForever(errorObserver)

        viewModel.getAustinRestaurantsList()

        verify(businessRepository).getAustinRestaurantsList()

        val expectedResult = "${exception.message}"
        verify(errorObserver).onChanged(expectedResult)

        viewModel.error.removeObserver(errorObserver)
    }
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
}