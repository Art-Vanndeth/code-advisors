import { Card, CardHeader, CardContent } from '@/components/ui/card';
import { Badge } from '@/components/ui/badge';
import { Avatar, AvatarFallback, AvatarImage } from '@radix-ui/react-avatar';
import { FireExtinguisher, Heart, ThumbsUp } from 'lucide-react';

export function ContentSection({
  cover,
  title,
  tags,
  description,
  author,
  reactions
}: any) {
  return (
    <div className="px-[250px]">
      <Card className="rounded-[5px] shadow-none">
        <img
          src={cover}
          className="9-0 h-80 w-full rounded-t-[5px] object-cover"
        />
        <div className="mx-20">
          <CardHeader>
            <h1 className="py-2 text-4xl font-bold">{title}</h1>
            <div className="flex flex-wrap gap-2 pb-2">
              {tags?.map((tag : any, index : number)  => (
                <Badge
                  key={index}
                  variant="outline"
                  className="rounded-[5px] border-secondary text-xs font-medium text-primary"
                >
                  #{tag}
                </Badge>
              ))}
            </div>

            <div className="pt-4">
              <div className="w-full max-w-sm">
                <div className="flex flex-row items-center gap-4">
                  <Avatar>
                    <AvatarImage
                      className="h-8 w-8 rounded-[100%]"
                      src="https://pbs"
                      alt="@shadcn"
                    />
                    <AvatarFallback>CN</AvatarFallback>
                  </Avatar>
                  <div className="flex flex-col">
                    <h2 className="text-sm font-semibold">{author}</h2>
                    {/* <p className="text-xs text-muted-foreground">{postDate}</p> */}
                  </div>
                </div>
              </div>
            </div>
          </CardHeader>
          <CardContent>{description}</CardContent>
        </div>
      </Card>
    </div>
  );
}
