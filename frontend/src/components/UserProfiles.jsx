import { useState, useEffect, useCallback } from 'react';
import axios from 'axios';
import { useDropzone } from 'react-dropzone';
import './userprofiles.css';
import Image from './Image';

function Dropzone({ profile }) {
  const onDrop = useCallback((acceptedFiles) => {
    const file = acceptedFiles[0];
    const formData = new FormData();
    formData.append('file', file);
    axios
      .post(
        `http://localhost:8080/api/v1/profile/${profile.userProfileId}/image/upload`,
        formData,
        {
          headers: { 'Content-Type': 'multipart/form-data' },
        }
      )
      .then((response) => {
        console.log(response.status);
        window.location.reload();
      })
      .catch((error) => {
        console.error(error.message);
      });
  }, []);
  const { getRootProps, getInputProps, isDragActive } = useDropzone({ onDrop });

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {isDragActive ? (
        <p>Drop the files here ...</p>
      ) : (
        <p>Drag and drop some files here, or click to select files</p>
      )}
    </div>
  );
}

const UserProfiles = () => {
  const [userProfiles, setUserProfiles] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/profile').then((response) => {
      setUserProfiles(response.data);
      console.log(userProfiles);
    });
  }, []);

  return (
    <div className="container">
      {userProfiles.map((profile) => (
        <div className="profile-container" key={profile.userProfileId}>
          <h4>{profile.userProfileId}</h4>
          <br />
          {profile.userProfileImageLink ? (
            <Image id={profile.userProfileId} profile={profile} />
          ) : null}
          <Dropzone profile={profile} />
          <h1>{profile.userName}</h1>
          <br />
        </div>
      ))}
    </div>
  );
};

export default UserProfiles;
