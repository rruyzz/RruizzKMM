import SwiftUI
import shared

struct DetailSuccessUi: View {
    
    @State var content: DetailContent?
    @Environment(\.dismiss) private var dismiss // Para voltar à tela anterior

    var body: some View {
        ScrollView {
            VStack(alignment: .leading) {
                CustomToolbar(
                    title: "Descrição",
                    backAction: { dismiss() },
                    saveAction: { print("Salvar pressionado") },
                    isSaved: content?.isSaved ?? false
                )
                BackgroundPoster(
                    grade: content?.grade ?? "",
                    title: content?.title ?? "",
                    backgroundPoster: content?.backgroundPoster ?? "",
                    poster: content?.poster ?? ""
                )
                VStack {
                    InfosView(
                        year: content?.year ?? "djksfj",
                        minutes: content?.minute ?? "dsff"
                    )
                    Text("Descrição")
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .font(.headline)
                        .padding()
                    Text(content?.description ?? "")
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .font(.subheadline)
                        .padding()
                }
                .offset(x: 0, y: 75)
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .navigationBarBackButtonHidden(true)
    }
}

#Preview {
    DetailSuccessUi()
}
