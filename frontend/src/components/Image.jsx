import { useEffect } from 'react';

const Image = ({ id, profile }) => {
  console.log(profile);
  return (
    <>
      <img
        style={{ height: '250px', width: '250px' }}
        src={`http://localhost:8080/api/v1/profile/${id}/image/download`}
        alt="Profile Image"
      />
    </>
  );
};

export default Image;
