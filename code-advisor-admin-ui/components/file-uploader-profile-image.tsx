/* eslint-disable @next/next/no-img-element */
import React, { useEffect, useState } from 'react';
import { Camera } from 'lucide-react';
import { cn } from '@/lib/utils';

const ImageUpload = ({ form, name, profileImage }: any) => {
  const [preview, setPreview] = useState<string | ArrayBuffer | null>(null);

  const handleImageChange = (e: any) => {
    const file = e.target.files[0];
    if (file) {
      form.setValue(name, e.target.files);
      const reader = new FileReader();
      reader.onloadend = () => {
        setPreview(typeof reader.result === 'string' ? reader.result : null);
      };
      reader.readAsDataURL(file);
    }
  };

  return (
    <div className="mb-6">
      <label className="mb-2 block text-sm font-medium">Profile Image</label>
      <div className="relative h-24 w-24">
        <input
          type="file"
          accept="image/jpeg,image/jpg,image/png,image/webp"
          className="hidden"
          id="imageUpload"
          onChange={handleImageChange}
        />
        <img
          src={typeof preview === 'string' ? preview : profileImage}
          alt="Profile"
          className={cn(
            'h-full w-full rounded-full object-cover',
            form.formState.errors[name] && 'border-2 border-red-500'
          )}
        />
        <label
          htmlFor="imageUpload"
          className="absolute bottom-0 right-0 mr-9 cursor-pointer rounded-full  border p-1 shadow-lg hover:bg-gray-100"
        >
          <Camera className="h-4 w-4" />
        </label>
      </div>
      {form.formState.errors[name] && (
        <p className="mt-2 text-sm text-red-500">
          {form.formState.errors[name].message}
        </p>
      )}
      <p className="mt-2 text-sm text-gray-500">
        This is your profile picture. It will display on the as a profile image.
      </p>
    </div>
  );
};

export default ImageUpload;
