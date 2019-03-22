package managers;


import pages.SearchPage;
import testBase.TestBase;

public class PageObjectManager extends TestBase {

	
SearchPage objSearchPage;


	
	public SearchPage getSearchPage() {
		return (objSearchPage == null) ? objSearchPage = new SearchPage(driver) : objSearchPage;
	}


}
