$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SCP_RQC_SearchItem.feature");
formatter.feature({
  "line": 2,
  "name": "Perform search in amazon online portal",
  "description": "",
  "id": "perform-search-in-amazon-online-portal",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@SearchItem"
    }
  ]
});
formatter.before({
  "duration": 14532939300,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Search for data catalog under book category",
  "description": "",
  "id": "perform-search-in-amazon-online-portal;search-for-data-catalog-under-book-category",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@SearchBooks_1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User has launched the application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Validate the user has navigated to home page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Select the category from dropdown",
  "rows": [
    {
      "cells": [
        "TestScenarioName"
      ],
      "line": 10
    },
    {
      "cells": [
        "SearchBooks_1"
      ],
      "line": 11
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Enter item to search in text box",
  "rows": [
    {
      "cells": [
        "TestScenarioName"
      ],
      "line": 13
    },
    {
      "cells": [
        "SearchBooks_1"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Click on search",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Validate the search results",
  "rows": [
    {
      "cells": [
        "TestScenarioName"
      ],
      "line": 17
    },
    {
      "cells": [
        "SearchBooks_1"
      ],
      "line": 18
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Fetch and store the results",
  "rows": [
    {
      "cells": [
        "TestScenarioName"
      ],
      "line": 20
    },
    {
      "cells": [
        "SearchBooks_1"
      ],
      "line": 21
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_has_launched_the_application()"
});
formatter.result({
  "duration": 315423900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.validate_the_user_has_navigated_to_home_page()"
});
formatter.result({
  "duration": 3444495100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.select_the_category_from_dropdown(DataTable)"
});
formatter.result({
  "duration": 6829647800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.enter_item_to_search_in_text_box(DataTable)"
});
formatter.result({
  "duration": 1639181200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.click_on_search()"
});
formatter.result({
  "duration": 69100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.validate_the_search_results(DataTable)"
});
formatter.result({
  "duration": 6220449400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.fetch_and_store_the_results(DataTable)"
});
formatter.result({
  "duration": 5939522000,
  "status": "passed"
});
formatter.write("Current Page URL is https://www.amazon.com/s?k\u003dData+catalog\u0026i\u003dstripbooks-intl-ship\u0026ref\u003dnb_sb_noss_2");
formatter.after({
  "duration": 3675504900,
  "status": "passed"
});
formatter.before({
  "duration": 12865492200,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Search for data catalog under book category",
  "description": "",
  "id": "perform-search-in-amazon-online-portal;search-for-data-catalog-under-book-category",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@SearchBooks_2"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "User has launched the application",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Validate the user has navigated to home page",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Select the category from dropdown",
  "rows": [
    {
      "cells": [
        "TestScenarioName"
      ],
      "line": 29
    },
    {
      "cells": [
        "SearchBooks_1"
      ],
      "line": 30
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Select item from suggestions",
  "rows": [
    {
      "cells": [
        "TestScenarioName"
      ],
      "line": 32
    },
    {
      "cells": [
        "SearchBooks_1"
      ],
      "line": 33
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "Validate the search results",
  "rows": [
    {
      "cells": [
        "TestScenarioName"
      ],
      "line": 35
    },
    {
      "cells": [
        "SearchBooks_1"
      ],
      "line": 36
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "Fetch and store the results",
  "rows": [
    {
      "cells": [
        "TestScenarioName"
      ],
      "line": 38
    },
    {
      "cells": [
        "SearchBooks_1"
      ],
      "line": 39
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_has_launched_the_application()"
});
formatter.result({
  "duration": 755500,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.validate_the_user_has_navigated_to_home_page()"
});
formatter.result({
  "duration": 1631209100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.select_the_category_from_dropdown(DataTable)"
});
formatter.result({
  "duration": 787501600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.select_item_from_suggestions(DataTable)"
});
formatter.result({
  "duration": 7519436300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.validate_the_search_results(DataTable)"
});
formatter.result({
  "duration": 6181284300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.fetch_and_store_the_results(DataTable)"
});
formatter.result({
  "duration": 2576067800,
  "status": "passed"
});
formatter.write("Current Page URL is https://www.amazon.com/s?k\u003ddata+catalog\u0026i\u003dstripbooks-intl-ship\u0026ref\u003dnb_sb_noss");
formatter.after({
  "duration": 4025113700,
  "status": "passed"
});
});