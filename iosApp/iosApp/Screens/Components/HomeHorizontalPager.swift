import SwiftUI

struct HomeHorizontalPager: View {
    
    let segments: [TabItem] = [TabItem.nowPlaying, TabItem.popular, TabItem.topRated]
    @State private var currentSegment = TabItem.nowPlaying

    var body: some View {
        VStack {
            SegmentedView(segments: segments, selected: $currentSegment)
            Spacer()
        }
    }
}

struct SegmentedView : View {
    
    var segments: [TabItem]
    @Binding var selected: TabItem
    @Namespace var name

    var body: some View {
        HStack(spacing: 0) {
            ForEach(segments, id: \.self) { segment in
                Button {
                    selected = segment
                } label: {
                    VStack {
                        Text(segment.title)
                            .foregroundColor(selected == segment ? .green : Color(uiColor: .systemGray))
                        ZStack {
                            Capsule()
                                .fill(Color.clear)
                                .frame(height: 4)
                            if selected == segment {
                                Capsule()
                                    .fill(Color.green)
                                    .frame(height: 4)
                                    .matchedGeometryEffect(id: "Tab", in: name)
                            }
                        }
                    }
                }
            }
        }
    }
}

struct MovieCard: View {
    var title: String
    var imageName: String
    
    var body: some View {
        VStack {
            Image(imageName)
                .resizable()
                .scaledToFill()
                .frame(width: 150, height: 200)
                .cornerRadius(10)
                .clipped()
            
            Text(title)
                .font(.headline)
                .foregroundColor(.white)
                .padding(.top, 8)
        }
        .frame(width: 150)
        .padding(.horizontal, 5)
    }
}

enum TabItem: String {
    case nowPlaying = "Now Playing"
    case popular = "Popular"
    case topRated = "Top Rated"
    
    var title: String {
        return self.rawValue
    }
}

#Preview {
    HomeHorizontalPager()
}
