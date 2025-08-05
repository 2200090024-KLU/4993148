package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create a mock object for the ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the getData() method to return predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Use the mock object in MyService
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Verify the result
        assertEquals("Mock Data", result);

        // Optionally verify interaction
        verify(mockApi, times(1)).getData();
    }
}
