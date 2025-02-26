'use client';
import * as React from 'react';
import { zodResolver } from '@hookform/resolvers/zod';
import { useForm } from 'react-hook-form';
import * as z from 'zod';
import { Button } from '@/components/ui/button';
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage
} from '@/components/ui/form';
import { Input } from '@/components/ui/input';
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue
} from '@/components/ui/select';
import { RadioGroup, RadioGroupItem } from '@/components/ui/radio-group';
import { Card, CardHeader, CardTitle, CardContent } from '@/components/ui/card';
import {
  ArrowBigUp,
  Bookmark,
  Calendar,
  CircleArrowDown,
  CircleArrowUp,
  MessageSquare,
  Share2,
  User
} from 'lucide-react';

const formSchema = z.object({
  name: z.string().min(2, {
    message: 'Name must be at least 2 characters.'
  }),
  country: z.string({
    required_error: 'Please select a country.'
  }),
  email: z.string().email({
    message: 'Please enter a valid email address.'
  }),
  company: z.string().min(1, {
    message: 'Company name is required.'
  }),
  gender: z.enum(['male', 'female', 'other'], {
    required_error: 'Please select a gender.'
  })
});

export default function ForumForm() {
  const details = [
    {
      icon: <ArrowBigUp className="h-5 w-5 text-gray-500" />,
      label: 'Total vote',
      value: '400'
    },
    {
      icon: <MessageSquare className="h-5 w-5 text-gray-500" />,
      label: 'Total comment',
      value: '30'
    },
    {
      icon: <Bookmark className="h-5 w-5 text-gray-500" />,
      label: 'Total bookmark',
      value: '20'
    },
    {
      icon: <User className="h-5 w-5 text-gray-500" />,
      label: 'Creator',
      value: 'Yith Sopheaktra'
    },
    {
      icon: <Calendar className="h-5 w-5 text-gray-500" />,
      label: 'Publish',
      value: '18-11-2024'
    }
  ];
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      name: '',
      country: '',
      email: '',
      company: '',
      gender: undefined
    }
  });

  function onSubmit(values: z.infer<typeof formSchema>) {
    console.log(values);
  }

  return (
    <div className="flex gap-4 rounded-[5px]  bg-white p-4">
      {/* Content */}
      <Card className='mx-auto w-full'>
        <CardHeader>
          <CardTitle className="text-3xl font-bold">Fourm Detail</CardTitle>
        </CardHeader>
        <CardContent className="space-y-4">
          <h2 className="text-xl font-bold">How to patch KDE on FreeBSD?</h2>
          <p className="text-gray-700">
            Mi magna sed nec nisl mattis. Magna cursus tincidunt rhoncus
            imperdiet fermentum pretium, pharetra nisl. Euismod.
          </p>

          {/* Code Block */}
          <div className="rounded-md bg-gray-100 p-4 font-mono text-sm">
            <pre className="space-y-1">
              <div>package main</div>
              <div>&nbsp;</div>
              <div>import &quot;fmt&quot;</div>
              <div>&nbsp;</div>
              <div>func main() {'{'}</div>
              <div> fmt.Println(&quot;Hello, world!&quot;)</div>
              <div>{'}'}</div>
            </pre>
          </div>

          <p className="text-gray-700">
            Posuere arcu arcu consectetur turpis rhoncus tellus. Massa,
            consectetur massa sit fames nulla eu vehicula ullamcorper. Ante sit
            mauris elementum sollicitudin arcu sit suspendisse pretium. Nisl
            egestas fringilla justo bibendum.
          </p>

          {/* Tags */}
          <div className="flex gap-2">
            {['java', 'javascript', 'spring'].map((tag) => (
              <span
                key={tag}
                className="rounded-[5px] border border-secondary px-3 py-1 text-sm text-primary"
              >
                #{tag}
              </span>
            ))}
          </div>
        </CardContent>
      </Card>
      <Card className="mx-auto w-[600px]">
        <CardHeader>
          <CardTitle className="text-3xl font-bold">Fourm Detail</CardTitle>
        </CardHeader>
        <CardContent className="space-y-4">
          {details.map((item, index) => (
            <div
              key={index}
              className="flex items-center gap-3 rounded-lg bg-gray-50 p-3"
            >
              {item.icon}
              <span className="text-gray-700">
                {item.label} : {item.value}
              </span>
            </div>
          ))}
        </CardContent>
      </Card>
    </div>
  );
}
