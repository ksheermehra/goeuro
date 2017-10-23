# goeuro Coding Challenge

##notes
- did not implement Docker package
- smoke test passes
- tested again sample data & example data from the original repo
- tested service.sh to work properly, compiling and passing unit tests at the time of writing this document

## invocation
invocation with `service.sh`, using example data from goeuro repo
```
	./service.sh dev_run data/example
```

invocation with `service.sh`, using sample data from the requirements doc (this data is also used in unit test)
```
	./service.sh dev_run src/test/resources/data.txt
```

##results of smoke test from `service.sh`
- with example data:
```
$ ./service.sh dev_smoke
Invoking: dev_smoke
Running smoke tests on http://localhost:8088...
{"dep_sid":3,"arr_sid":4,"direct_bus_route":false}
{"dep_sid":0,"arr_sid":1,"direct_bus_route":false}
Tests Passed
```
- with test data
```
$ ./service.sh dev_smoke
Invoking: dev_smoke
Running smoke tests on http://localhost:8088...
{"dep_sid":3,"arr_sid":4,"direct_bus_route":true}
{"dep_sid":0,"arr_sid":1,"direct_bus_route":true}
Tests Passed
```