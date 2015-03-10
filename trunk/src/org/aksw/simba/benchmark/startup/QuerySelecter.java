package org.aksw.simba.benchmark.startup;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.aksw.simba.benchmark.clustring.QueryClustering;
import org.aksw.simba.benchmark.log.operations.CleanQueryReader;

public class QuerySelecter {

	public static void main(String[] args) throws IOException {
		String queryFileWithStats = "CleanQueries.txt";
		Map<String, Double[]> normalizedVectors = 	CleanQueryReader.getNormalizedFeaturesVectors(queryFileWithStats);
		QueryClustering qc = new QueryClustering();
		Set<String> queries = qc.getPrototypicalQueries(normalizedVectors, 5);
		int count = 1;
		for(String query:queries)
		{
			String [] qryParts = query.split("Query String:");
			System.out.println(count+":----------------------\nQuery Features: \n\n"+qryParts[0]+ "\nQuery: \n"+qryParts[1]);
			count++;
		}

	}

}