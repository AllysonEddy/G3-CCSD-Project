import React, { useEffect, useState } from "react";
import axios from "axios";

export const Features = () => {
  const [featuresData, setFeaturesData] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchFeaturesData = async () => {
      try {
        const response = await axios.get("http://localhost:8082/api/websitetext");
        
        const formattedData = response.data.map((item) => ({
          title: item.title,
          text: item.description, 
          icon: "fa fa-star", 
        }));

        setFeaturesData(formattedData);
      } catch (err) {
        console.error("Error fetching features data:", err);
        setError("Failed to load features.");
      } finally {
        setIsLoading(false);
      }
    };

    fetchFeaturesData();
  }, []);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div id="features" className="text-center">
      <div className="container">
        <div className="col-md-10 col-md-offset-1 section-title">
          <h2>Features</h2>
        </div>
        <div className="row">
          {featuresData && featuresData.length > 0 ? (
            featuresData.map((d, i) => (
              <div key={`${d.title}-${i}`} className="col-xs-6 col-md-3">
                <i className={d.icon}></i>
                <h3>{d.title}</h3>
                <p>{d.text}</p>
              </div>
            ))
          ) : (
            <p>No features available.</p>
          )}
        </div>
      </div>
    </div>
  );
};

