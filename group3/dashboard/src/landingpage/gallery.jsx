import React, { useEffect, useState } from 'react';
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8082';

export const Gallery = () => {
  const [gallery, setGallery] = useState([]);

  useEffect(() => {
    const fetchGallery = async () => {
      const token = localStorage.getItem('jwtToken');
      try {
        const response = await axios.get(`${API_BASE_URL}/api/gallery`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setGallery(response.data);
        console.log(response.data);
      } catch (error) {
        console.error('Error fetching gallery:', error);
      }
    };

    fetchGallery();
  }, []);

  if (!gallery.length) {
    return <div>Loading...</div>;
  }

  return (
    <div id="portfolio" className="text-center">
      <div className="container">
        <div className="section-title">
          <h2>Gallery</h2>
          <p>"Have a favourite cafe moment? Tag us on social media for a chance to be featured here"</p>
        </div>
        <div className="row">
          <div className="portfolio-items">
            {gallery.map((d, i) => (
              <div key={`${d.title}-${i}`} className="col-sm-6 col-md-4 col-lg-4">
                {d.image ? (
                  <img
                    src={`data:image/jpeg;base64,${d.image}`}
                    alt={d.title}
                    className="img-fluid"
                    style={{ width: '400px', height: '300px' }}
                  />
                ) : (
                  <p>No Image Available</p>
                )}
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};
