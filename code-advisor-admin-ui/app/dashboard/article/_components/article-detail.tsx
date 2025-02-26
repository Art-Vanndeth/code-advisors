/* eslint-disable react/no-unescaped-entities */
import React from 'react';
import { ContentSection } from './article-section';

export default function ArticleDetail() {
  const content = {
    cover:
      'https://www.hdwallpapers.in/download/abstract_cover_background_4k_hd-2560x1440.jpg',
    title: 'Web Development Trends',
    tags: ['web development', 'trends'],
    author: 'John Doe',
    reactions: {
      likes: 10,
      comments: 2,
      shares: 5
    }
  };

  return (
    <>
      <ContentSection
        cover={content?.cover}
        title={content?.title}
        tags={content?.tags}
        author={content?.author}
        reactions={content?.reactions}
        description={
          <div className="space-y-4">
            <p>
              Web development is constantly evolving, with new technologies and
              frameworks emerging regularly. In this post, we'll explore some of
              the latest trends and what they mean for developers.
            </p>
            <h2 className="text-xl font-semibold">Key Trends</h2>
            <ul className="list-disc pl-6">
              <li>Serverless architectures</li>
              <li>JAMstack and static site generators</li>
              <li>Progressive Web Apps (PWAs)</li>
            </ul>
            <img
              src="https://i.pinimg.com/736x/03/1d/a9/031da9ff8b2baafbcba8e0358d7420fc.jpg"
              alt="Web Development Trends"
              width={500}
              height={300}
              className="h-auto w-full rounded-[5px]"
            />
            <h2 className="text-xl font-semibold">Impact on Developers</h2>
            <ol className="list-decimal pl-6">
              <li>Increased focus on frontend skills</li>
              <li>Growing importance of API design</li>
              <li>Need for continuous learning and adaptation</li>
            </ol>
            <p>
              As these trends continue to shape the industry, developers must
              stay informed and adapt their skills accordingly.
            </p>
            <img
              src="https://i.pinimg.com/736x/ed/f4/38/edf438e51cb26e1b312c3fc0d63936a6.jpg"
              alt="Web Development Trends"
              className="h-auto w-full rounded-[5px]"
            />
          </div>
        }
      />
    </>
  );
}
